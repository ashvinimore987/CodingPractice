package stack;

import java.util.*;

public class NGR {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        //7 8 1 4
        // Your code here
        Stack<Long> s=new Stack<>();
        List<Long> v=new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            if(s.isEmpty())
            {
                v.add(-1l);
            }
            else if(s.size()>0 && s.peek()>=arr[i])
            {
                v.add(s.peek());
            }// 7 8 1 4
            else if(!s.isEmpty() && s.peek()<=arr[i])
            {
                while(s.size()>0 && s.peek()<=arr[i])
                {
                    s.pop();
                }
                if(s.isEmpty())
                {
                    v.add(-1l);
                }
                else
                {
                    v.add(s.peek());
                }
            }

            s.push(arr[i]);
        }
        Collections.reverse(v);
        // return v.toArray(new long[0]);
        return v.stream().
                mapToLong(Long::longValue).
                toArray();

    }

    public static void main(String[] args) {
        long[] a = {7,8,1,4};

        long[] k = nextLargerElement(a,4);
        for (long e : k){
            System.out.println(e);
        }

        // Arrays.asList( nextLargerElement(a,4)).forEach(System.out::println);
    }
}
