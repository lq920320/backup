```javascript
let list = [ 
    { Phase: "Phase 1", Step: "Step 1", Task: "Task 1", Value: "5" },
    { Phase: "Phase 1", Step: "Step 1", Task: "Task 2", Value: "10" },
    { Phase: "Phase 1", Step: "Step 2", Task: "Task 1", Value: "15" },
    { Phase: "Phase 1", Step: "Step 2", Task: "Task 2", Value: "20" },
    { Phase: "Phase 2", Step: "Step 1", Task: "Task 1", Value: "25" },
    { Phase: "Phase 2", Step: "Step 1", Task: "Task 2", Value: "30" },
    { Phase: "Phase 2", Step: "Step 2", Task: "Task 1", Value: "35" },
    { Phase: "Phase 2", Step: "Step 2", Task: "Task 2", Value: "40" }
];

console.log(groupByArray(list, 'Phase', 'Value'));

function groupByArray(values, key, valueName) {
      return values.reduce(function(rv, value) {
        console.log("rv:      ", rv);
        console.log("value:   ", value);
        let v = key instanceof Function ? key(value) : value[key];
        let param = valueName instanceof Function ? valueName(value) : value[valueName];
        console.log("vvvv:    ", v);
        let el = rv.find(r => r && r.key === v);
        console.log("el:      ", v);
        if (el) {
          console.log("VALUE:   ", param);
          el.values.push(value);
        } else {
          rv.push({ key: v, values: [value] });
        }
        return rv;
      }, []);
    };


var pattern = /(?:[\u2700-\u27bf]|(?:\ud83c[\udde6-\uddff]){2}|[\ud800-\udbff][\udc00-\udfff]|[\u0023-\u0039]\ufe0f?\u20e3|\u3299|\u3297|\u303d|\u3030|\u24c2|\ud83c[\udd70-\udd71]|\ud83c[\udd7e-\udd7f]|\ud83c\udd8e|\ud83c[\udd91-\udd9a]|\ud83c[\udde6-\uddff]|[\ud83c[\ude01\uddff]|\ud83c[\ude01-\ude02]|\ud83c\ude1a|\ud83c\ude2f|[\ud83c[\ude32\ude02]|\ud83c\ude1a|\ud83c\ude2f|\ud83c[\ude32-\ude3a]|[\ud83c[\ude50\ude3a]|\ud83c[\ude50-\ude51]|\u203c|\u2049|[\u25aa-\u25ab]|\u25b6|\u25c0|[\u25fb-\u25fe]|\u00a9|\u00ae|\u2122|\u2139|\ud83c\udc04|[\u2600-\u26FF]|\u2b05|\u2b06|\u2b07|\u2b1b|\u2b1c|\u2b50|\u2b55|\u231a|\u231b|\u2328|\u23cf|[\u23e9-\u23f3]|[\u23f8-\u23fa]|\ud83c\udccf|\u2934|\u2935|[\u2190-\u21ff])/g;

var str2 = 'ℹ😂〰';
var str1 = 'ℹ😂〰asdfasd';
var str3 = 'asdasda';

var isContainEmojis = str=>str.replace(pattern, '').length < str.length;

console.log(isContainEmojis(str2) ? "It contains emojis!" : "It doesn't contain emojis!")
console.log(isContainEmojis(str1) ? "It contains emojis!" : "It doesn't contain emojis!")
console.log(isContainEmojis(str3) ? "It contains emojis!" : "It doesn't contain emojis!")
哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈

var jangoFett = {
    occupation: "Bounty Hunter",
    genetics: "superb"
};

var bobaFett = {
    occupation: "Bounty Hunter",
    genetics: "superb"
};

function isEquivalent(a, b) {
    // Create arrays of property names
    var aProps = Object.getOwnPropertyNames(a);
    var bProps = Object.getOwnPropertyNames(b);

    // If number of properties is different,
    // objects are not equivalent
    if (aProps.length != bProps.length) {
        return false;
    }

    for (var i = 0; i < aProps.length; i++) {
        var propName = aProps[i];

        // If values of same property are not equal,
        // objects are not equivalent
        if (a[propName] !== b[propName]) {
            return false;
        }
    }

    // If we made it this far, objects
    // are considered equivalent
    return true;
}

// Outputs: true
console.log(isEquivalent(bobaFett, jangoFett));

```
