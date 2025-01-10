import edu.princeton.cs.algs4.StdAudio;
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String arg[]) {
        GuitarString[] keys = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double freq = (double) 440 * Math.pow(2, (i - 24) / 12.0);
            keys[i] = new GuitarString(freq);
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyAt = keyboard.indexOf(key);
                if (keyAt == -1) {
                    continue;
                }
                keys[keyAt].pluck();
            }

            double sample = 0;
            for (GuitarString i : keys){
                sample += i.sample();
            }

            StdAudio.play(sample);

            for (GuitarString i : keys) {
                i.tic();
            }
        }
    }
}
