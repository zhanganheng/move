package com.bw.movie.utils;


import android.os.Environment;

import com.bw.library.app.App;


/**
 * Describe：Constant
 * Author：fan
 * Data：2019/11/7
 * Time:9:08
 */

public class Constant {
    public final static String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + App.getAppContext().getPackageName();
    public final static String DOWNLOAD_DIR = "/downlaod/";


}
