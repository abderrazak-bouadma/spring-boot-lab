#!/bin/bash
curl localhost:9095/version | python -mjson.tool
