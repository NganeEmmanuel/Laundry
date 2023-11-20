package com.laundry.laundry.helper.helper;


import java.lang.reflect.Method;

public class Merger {
    /**
     *
     * @param t object to be updated
     * @param s object whose information will be used to update object t
     * @return returns an updated object t with information of s
     * @param <T> class type
     */
    public static <T> T merge(T t, T s){

        // Get the Class object representing the type of 'T'
        Class<?> clazz = t.getClass();
        Method[] methods = clazz.getMethods();
        for(Method method: methods){
            if (isGetter(method)) {
                // Get the method name
                String methodName = method.getName();

                try {
                    // Get the corresponding getter method in 's'
                    Method getterMethod = clazz.getMethod(methodName);

                    // Invoke the getter method on 's' to retrieve the value
                    Object value = getterMethod.invoke(s);

                    // Call the setter method on 't' to update the value
                    method.invoke(t, value);
                } catch (Exception e) {
                    // Handle any exceptions that may occur
//                    throw new RuntimeException();
                    e.printStackTrace();
                }
            }
        }
        return t;
    }

    /**
     *
     * @param method the method you wish to check if it is a getter
     * @return true if method is a getter and false otherwise
     */
    private static boolean isGetter(Method method) {
        String methodName = method.getName();
        return methodName.startsWith("get") && methodName.length() > 3 && method.getParameterTypes().length == 0;
    }
}


