public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double dx = xxPos - b.xxPos;
        double dy = yyPos - b.yyPos;
        double dist = Math.sqrt(dx * dx + dy * dy);

        return dist;
    }

    public double calcForceExertedBy(Body b){
        double dist = calcDistance(b);
        double force = (G * mass * b.mass) / (dist * dist);

        return force;
    }

    public double calcForceExertedByX(Body b){
        double dist = calcDistance(b);
        double dx = b.xxPos - xxPos;
        double force = calcForceExertedBy(b);
        double netForce = force * dx / dist;

        return netForce;
    }

    public double calcForceExertedByY(Body b){
        double dist = calcDistance(b);
        double dx = b.yyPos - yyPos;
        double force = calcForceExertedBy(b);
        double netForce = force * dx / dist;

        return netForce;
    }

    public double calcNetForceExertedByX(Body[] bodies){
        double netForce = 0;
        for (Body b : bodies){
            if (b.equals(this)){
                continue;
            }

            netForce += calcForceExertedByX(b);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Body[] bodies){
        double netForce = 0;
        for (Body b : bodies){
            if (b.equals(this)){
                continue;
            }

            netForce += calcForceExertedByY(b);
        }
        return netForce;
    }

    public void update(double time, double Fx, double Fy){
        double ax = Fx / mass;
        double ay = Fy / mass;

        xxVel = xxVel + time * ax;
        yyVel = yyVel + time * ay;
        xxPos = xxPos + time * xxVel;
        yyPos = yyPos + time * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
