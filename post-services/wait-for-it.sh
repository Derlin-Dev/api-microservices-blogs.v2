#!/usr/bin/env bash

# wait-for-it.sh
# Usage: wait-for-it.sh host:port [-t timeout]

host=$1
shift
port=$1
shift
timeout=${1:-30}

echo "Waiting for $host:$port to be available..."

start_ts=$(date +%s)
while ! nc -z $host $port; do
  if [ $(($(date +%s) - $start_ts)) -ge $timeout ]; then
    echo "Timeout reached, $host:$port is still not available."
    exit 1
  fi
  sleep 1
done

echo "$host:$port is available!"
exec "$@"
