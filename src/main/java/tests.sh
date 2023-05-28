for i in $(seq -f "%02g" 1 25); do
    echo "Parsing winzig_${i}:"
    java winzigc -ast winzig_test_programs/winzig_${i} > tree.${i}
    if diff -q tree.${i} winzig_test_programs/winzig_${i}.tree > /dev/null; then
        echo "True: Files are identical"
        rm tree.${i}
    else
        echo "False: Files differ"
    fi
done
