package jvm;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.IOException;
import java.lang.reflect.Modifier;


/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月04日 21:20
 */
public class MyClassLoad {


    private static byte[] genClass() throws CannotCompileException, IOException {
       //java assist
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("greetings.Go");
        CtMethod method = new CtMethod(CtClass.voidType, "greetings", new CtClass[]{}, ctClass);
        method.setModifiers(Modifier.PUBLIC);
        method.setBody("{ System.out.println(\"Hi Greetings!!\" )};");
        ctClass.addMethod(method);
        return ctClass.toBytecode();

    }


}
