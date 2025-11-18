#!/bin/bash
# Test runner script for EmojX
# Runs all example programs and verifies they execute without errors

set -e  # Exit on error

# Color codes for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo "🎨 EmojX Test Suite Runner"
echo "=========================="
echo ""

# Check if Python is available
if ! command -v python &> /dev/null; then
    echo -e "${RED}❌ Error: Python not found${NC}"
    exit 1
fi

# Check if ANTLR runtime is installed
python -c "import antlr4" 2>/dev/null || {
    echo -e "${RED}❌ Error: antlr4-python3-runtime not installed${NC}"
    echo "Run: pip install -r requirements.txt"
    exit 1
}

# Count tests
total_tests=0
passed_tests=0
failed_tests=0

echo "📂 Running example programs..."
echo ""

# Run each example
for example_file in ejemplos/*.emojx; do
    total_tests=$((total_tests + 1))
    filename=$(basename "$example_file")
    
    echo -n "Testing $filename ... "
    
    # Run the example and capture output
    if python main.py "$example_file" > /tmp/emojx_test_output.txt 2>&1; then
        echo -e "${GREEN}✅ PASS${NC}"
        passed_tests=$((passed_tests + 1))
    else
        echo -e "${RED}❌ FAIL${NC}"
        echo "Output:"
        cat /tmp/emojx_test_output.txt
        echo ""
        failed_tests=$((failed_tests + 1))
    fi
done

echo ""
echo "=========================="
echo "📊 Test Summary"
echo "=========================="
echo "Total tests:  $total_tests"
echo -e "Passed:       ${GREEN}$passed_tests${NC}"
if [ $failed_tests -eq 0 ]; then
    echo -e "Failed:       ${GREEN}$failed_tests${NC}"
else
    echo -e "Failed:       ${RED}$failed_tests${NC}"
fi
echo ""

# Exit with appropriate code
if [ $failed_tests -eq 0 ]; then
    echo -e "${GREEN}🎉 All tests passed!${NC}"
    exit 0
else
    echo -e "${RED}❌ Some tests failed${NC}"
    exit 1
fi
