import java.awt.Color;

public class KernelFilter {

    private static int clamp(int a) {
        if (a < 0)
            return 0;
        else if (a > 255)
            return 255;
        else
            return a;
    }

    // Returns a new picture that applies the identity filter to the given
    // picture.
    public static Picture identity(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        int[][] kernel = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp(red);
                finalGreen = clamp(green);
                finalBlue = clamp(blue);
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;

    }

    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        double mult = 16.0;
        int[][] kernel = {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp((int) Math.round(red / mult));
                finalGreen = clamp((int) Math.round(green / mult));
                finalBlue = clamp((int) Math.round(blue / mult));
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;

    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        int[][] kernel = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp(red);
                finalGreen = clamp(green);
                finalBlue = clamp(blue);
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;

    }

    // Returns a new picture that applies an Laplacian filter to the given
    // picture.
    public static Picture laplacian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        int[][] kernel = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp(red);
                finalGreen = clamp(green);
                finalBlue = clamp(blue);
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        int[][] kernel = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp(red);
                finalGreen = clamp(green);
                finalBlue = clamp(blue);
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;
    }

    // Returns a new picture that applies a motion blur filter to the given
    // picture.
    public static Picture motionBlur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picFiltered = new Picture(width, height);

        double mult = 9.0;
        int[][] kernel = {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1 },

        };
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = 0, green = 0, blue = 0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int imageX = (x - kernel.length / 2 + i + width) % width;
                        int imageY = (y - kernel.length / 2 + j + height) % height;

                        Color kerColor = picture.get(imageX, imageY);
                        int r = kerColor.getRed();
                        int g = kerColor.getGreen();
                        int b = kerColor.getBlue();

                        red += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue += (b * kernel[i][j]);

                    }
                }
                int finalRed, finalGreen, finalBlue;
                finalRed = clamp((int) Math.round(red / mult));
                finalGreen = clamp((int) Math.round(green / mult));
                finalBlue = clamp((int) Math.round(blue / mult));
                picFiltered.set(x, y, new Color(finalRed, finalGreen, finalBlue));

            }
        }
        return picFiltered;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);

        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();

    }

}