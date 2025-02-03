# Get all files in ./src/**/*.java and use xargs to pass as positional arguments to javac
find ./src -name "*.java" | xargs javac -d ./out && \
cd out && \
java sales_project.App ||
cd -