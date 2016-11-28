package Amazon_OA;

public class Rectamgle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        return area1 + area2 - overLap(A, B, C, D, E, F, G, H);
    }
    private int overLap (int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || A >= G || B >= H || D <= F) {
            return 0;
        }
        int x = 0;
        int y = 0;
        if (A < E) {
            if (C >= G) {
                x = G - E;
            } else {
                x = C - E;
            }
        } else {
            if (C <= G) {
                x = C - A;
            } else {
                x = G - A;
            }
        }
        if (B < F) {
            if (D >= H) {
                y = H - F;
            } else {
                y = D - F;
            }
        } else {
            if (D <= H) {
                y = D - B;
            } else {
                y = H - B;
            }
        }
        return x * y;
    }
}