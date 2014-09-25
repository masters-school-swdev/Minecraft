#!/bin/bash

set -o errexit

echo -n "Downloading Forge 1.7.10 \(10.13.0.1180\) src distribution... "
wget http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.7.10-10.13.0.1180/forge-1.7.10-10.13.0.1180-src.zip
echo "done"

echo -n "Unpacking Forge..."
unzip forge-1.7.10-10.13.0.1180-src.zip
echo "done"

echo "Running Forge setup routine"
./gradlew setupDecompWorkspace --refresh-dependencies

echo "Setting up Eclipse workspace"
./gradlew eclipse

# clean up
rm -f forge-1.7.10-10.13.0.1180-src.zip

# fix up the default launch preferences supplied by Forge
# two Run/Debug configurations are supplied, point these
# to our Project directory rather than the workspace created
# by Forge
for F in `find eclipse/.metadata -type f -name \*.launch`; do
  sed 's/\${workspace_loc\}/\${project_loc}\/run/' $F > ${F}_ && mv ${F}_ $F
done
# Eclipse requires the run directory exist before launching...
mkdir run

# TODO download forge javadoc jar
