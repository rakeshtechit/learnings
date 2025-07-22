#!/bin/sh

# Start Ollama server in the background
ollama serve &

# Wait for Ollama server to be ready
echo "Waiting for Ollama to start..."
#until curl -s http://localhost:11434 > /dev/null; do
#  sleep 1
#done
#echo "Ollama server is ready."

# Define models to pull
MODELS="tinydolphin" # Add or remove models as needed

# Pull models if they don't exist
for MODEL in $MODELS; do
    if ! ollama list | grep -q "$MODEL"; then
    echo "Pulling model: $MODEL"
    ollama pull "$MODEL"
    else
    echo "Model '$MODEL' already present."
    fi
done

# Keep the container running
wait