package com.fxp.pattern_proxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgrammerZoro zoro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoro = new ProgrammerZoro();

//        commitNeedsToLuffy();

        commitNeedsToCompany();
    }

    private void commitNeedsToLuffy(){
        Log.d("fxp", "客户将需求提交给项目经理Luffy...");

        ProjectManagerLuffy luffy = new ProjectManagerLuffy(zoro);

        luffy.work();
    }

    private void commitNeedsToCompany(){
        Log.d("fxp", "客户提交需求...");

        Log.d("fxp", "指定项目经理Nami...");
        IDoProject nami = (IDoProject) Proxy.newProxyInstance(zoro.getClass().getClassLoader(), new Class[]{IDoProject.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 整理需求
                Log.d("fxp", "项目经理Nami整理需求...");

                // 评估需求是否合理
                boolean isReasonable = (new Random()).nextBoolean();
                Log.d("fxp", "项目经理Nami评估需求是否合理...");

                if (isReasonable){
                    // 需求合理-提交给程序员
                    Log.d("fxp", "需求评估结果为合理，项目经理Nami将需求提交给程序员Zoro...");

                    zoro.work();
                } else {
                    // 需求不合理-驳回
                    Log.d("fxp", "需求评估结果为不合理，项目经理Nami不将需求提交给程序员Zoro");
                }
                return null;
            }
        });
        nami.work();
    }
}
