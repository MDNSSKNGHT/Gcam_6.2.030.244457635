package com.google.googlex.gcam.androidutils.vecmath;

import java.nio.FloatBuffer;

public final class RectangleUtilities {
    public static final String TAG = "RectangleUtilities";

    private RectangleUtilities() {
    }

    public static Rect2f bestFitKeepAR(Vector2f vector2f, Rect2f rect2f) {
        float min = Math.min(rect2f.width(), (rect2f.height() * vector2f.x) / vector2f.y);
        float min2 = Math.min((rect2f.width() * vector2f.y) / vector2f.x, rect2f.height());
        return new Rect2f(rect2f.origin().x + ((rect2f.width() - min) * 0.5f), rect2f.origin().y + ((rect2f.height() - min2) * 0.5f), min, min2);
    }

    public static Rect2i bestFitKeepAR(Vector2i vector2i, Rect2i rect2i) {
        int min = Math.min(rect2i.width(), (rect2i.height() * vector2i.x) / vector2i.y);
        int min2 = Math.min((rect2i.width() * vector2i.y) / vector2i.x, rect2i.height());
        return new Rect2i(rect2i.origin().x + ((rect2i.width() - min) / 2), rect2i.origin().y + ((rect2i.height() - min2) / 2), min, min2);
    }

    public static void writeFullscreenRectangle(FloatBuffer floatBuffer) {
        writeRectangle(-1.0f, -1.0f, 2.0f, 2.0f, floatBuffer);
    }

    public static void writeRectangle(float f, float f2, float f3, float f4, FloatBuffer floatBuffer) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        floatBuffer.put(f);
        floatBuffer.put(f2);
        floatBuffer.put(f5);
        floatBuffer.put(f2);
        floatBuffer.put(f);
        floatBuffer.put(f6);
        floatBuffer.put(f5);
        floatBuffer.put(f6);
    }

    public static void writeRectangle(Rect2f rect2f, FloatBuffer floatBuffer) {
        writeRectangle(rect2f.origin().x, rect2f.origin().y, rect2f.width(), rect2f.height(), floatBuffer);
    }

    public static void writeRectangleLines(float f, float f2, float f3, float f4, FloatBuffer floatBuffer) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        floatBuffer.put(f);
        floatBuffer.put(f2);
        floatBuffer.put(f5);
        floatBuffer.put(f2);
        floatBuffer.put(f5);
        floatBuffer.put(f2);
        floatBuffer.put(f5);
        floatBuffer.put(f6);
        floatBuffer.put(f5);
        floatBuffer.put(f6);
        floatBuffer.put(f);
        floatBuffer.put(f6);
        floatBuffer.put(f);
        floatBuffer.put(f6);
        floatBuffer.put(f);
        floatBuffer.put(f2);
    }

    public static void writeRectangleLines(Rect2f rect2f, FloatBuffer floatBuffer) {
        writeRectangleLines(rect2f.origin().x, rect2f.origin().y, rect2f.width(), rect2f.height(), floatBuffer);
    }
}
