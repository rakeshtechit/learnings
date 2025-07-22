#!/bin/bash

echo "Starting Ollama server in the background..."
ollama serve &
SERVER_PID=$!

echo "Waiting for Ollama server to be active..."
# Wait for the server to be ready by checking the list of models
while ! ollama list > /dev/null 2>&1; do
    sleep 1
done
echo "Ollama server is active."

echo "Pulling the tinyllama model..."
ollama pull tinyllama

echo "Model pull complete. Server is running and ready to serve requests."

# Wait for the background server process to finish
wait $SERVER_PID
