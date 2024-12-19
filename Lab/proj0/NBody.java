public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Body[] readBodies(String path){
        In in = new In(path);
        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String name;

        int numberOfBodies = in.readInt();
        Body[] bodies = new Body[numberOfBodies];
        in.readDouble();

        for (int i = 0; i < numberOfBodies; i++){
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            name = in.readString();

            bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, name);
        }
        return bodies;
    }

    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius("data/" + filename);
        Body[] bodies = readBodies("data/" + filename);
        String backGroundImg = "images/starfield.jpg";

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        double time = 0;

        while (time <= T){
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            for (int i = 0; i < bodies.length; i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i = 0; i < bodies.length; i++){
                bodies[i].update(time, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, backGroundImg);
            for (Body b : bodies){
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
