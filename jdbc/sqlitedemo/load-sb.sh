#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

export PGPASSWORD=oggy2112
export PGUSER=postgres
export PGHOST=localhost
export PGDATABASE=localdb

psql -a -f ./data.sql