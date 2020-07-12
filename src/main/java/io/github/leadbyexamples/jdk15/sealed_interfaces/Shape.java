package io.github.leadbyexamples.jdk15.sealed_interfaces;

sealed interface Shape permits Circle, Rectangle {

    long area();
}
