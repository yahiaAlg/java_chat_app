#!/bin/bash

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile the source files
javac -d bin src/main/java/com/chat/server/*.java src/main/java/com/chat/client/*.java

echo "Build completed. Class files are in the bin directory."
