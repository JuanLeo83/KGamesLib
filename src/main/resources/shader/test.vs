#version 120

varying vect3 aPos;
varying vect4 aColor;

out vect4 fColor;

void main() {
    fColor = aColor;
    gl_Position = vect4(aPos, 1.0);
}