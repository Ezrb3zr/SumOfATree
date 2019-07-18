/* Usage would be for example

Foo a = new Foo(new Integer(10), new Integer(20));
Foo b = new foo(new Integer(5), new Integer(10));

Foo c = new Foo(a, b);
Foo d = new Foo(c, new Integer(9);

Integer sum = d.sumOfLeftAndRight();
// sum would be 10 + 20 + 5 + 10 + 9 = 54;
*/

class Foo {

    // left and right are either of type Integer or of type Foo, never any other type
    private Object left;
    private Object right;
    public Foo(Object left, Object right) { 
        this.left = left;
        this.right = right;
     }
    
   
    public Integer sumOfLeftAndRight() {
         return leftToRightTraversal(this);
    }
    
    public Integer leftToRightTraversal(Object currentFoo) {
        Integer sum = 0;
        if(currentFoo.left.instanceOf(Foo.class)){
            sum += leftToRightTraversal(currentFoo.left); 
        }
        if(currentFoo.right.instanceOf(Foo.class)){
            sum += leftToRightTraversal(currentFoo.right);
        }
        if(currentFoo.left.ofClass(Integer.class)){
             sum += currentFoo.left;
        }
        if(currentFoo.right.ofClass(Integer.class)){
            sum += currentFoo.right;
        }
        return sum;
    }
    

  
}