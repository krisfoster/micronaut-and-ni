#!/usr/bin/env bash
hey -z 10s http://localhost:8080/triangle/4
hey -z 10s http://localhost:8080/triangle/5
hey -z 10s http://localhost:8080/triangle/6
