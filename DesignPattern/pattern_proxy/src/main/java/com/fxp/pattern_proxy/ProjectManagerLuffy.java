package com.fxp.pattern_proxy;

import android.util.Log;

import java.util.Random;

/**
 * Title:       ProjectManagerLuffy
 * <p>
 * Package:     com.fxp.pattern_proxy
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/3/13 5:44 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/3/13    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class ProjectManagerLuffy implements IDoProject{

    private ProgrammerZoro zoro;

    public ProjectManagerLuffy(ProgrammerZoro zoro){
        this.zoro = zoro;
    }

    @Override
    public void work() {
        // 整理需求
        Log.d("fxp", "项目经理Luffy整理需求...");

        // 评估需求是否合理
        boolean isReasonable = (new Random()).nextBoolean();
        Log.d("fxp", "项目经理Luffy评估需求是否合理...");

        if (isReasonable){
            // 需求合理-提交给程序员
            Log.d("fxp", "需求评估结果为合理，项目经理Luffy将需求提交给程序员Zoro...");

            zoro.work();
        } else {
            // 需求不合理-驳回
            Log.d("fxp", "需求评估结果为不合理，项目经理Luffy不将需求提交给程序员Zoro");
        }
    }
}
