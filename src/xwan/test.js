/**
 * Created by xwan on 3/10/17.
 */
var add = function (a,b) {
    if (a && b) {
        return a + b;
    } else {
        return function (c) {
            return a + c;
        }
    }
}
console.log(add(1,2));
console.log(add(1)(2));

function fun(){
    var name = "Junga";
    function fun1(){
        var greet = 'Hello '+ name;
        console.log(greet);
    }
    return fun1;
}
var result = fun();
result();