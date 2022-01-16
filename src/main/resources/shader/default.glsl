#type vertex
#version 330 core
layout (location=0) in vect3 aPos;
layout (location=1) in vect4 aColor;

out vect4 fColor;

void main() {
    fColor = aColor;
    gl_Position = vect4(aPos, 1.0);
}

    #type fragment
    #version 330 core

in vect4 fColor;

out vect4 color;

void main() {
    color = fColor;
}
