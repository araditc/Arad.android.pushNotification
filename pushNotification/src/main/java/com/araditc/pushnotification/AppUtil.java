

/*
 * Copyright 2013 Square, Inc.
 *
 * Licensed under the Arad License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://arad-itc.com/%D8%AF%D8%B1%D8%A8%D8%A7%D8%B1%D9%87-%D9%85%D8%A7/%DA%AF%D9%88%D8%A7%D9%87%DB%8C%D9%86%D8%A7%D9%85%D9%87-%D8%A7%DB%8C%D8%B2%D9%88-90012008
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.araditc.pushnotification;

import android.os.Handler;
import android.os.Looper;

public final class AppUtil {
    public static void runOnUIThread(Looper looper, Runnable runnable, long delay) {
        Handler applicationHandler = new Handler(looper);

        if (delay == 0) {
            applicationHandler.post(runnable);
        } else {
            applicationHandler.postDelayed(runnable, delay);
        }
    }
}
