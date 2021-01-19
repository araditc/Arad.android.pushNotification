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

import com.araditc.pushnotification.struct.AudioStruct;
import com.araditc.pushnotification.struct.ContactStruct;
import com.araditc.pushnotification.struct.CustomStruct;
import com.araditc.pushnotification.struct.DocumentStruct;
import com.araditc.pushnotification.struct.ImageStruct;
import com.araditc.pushnotification.struct.LocationStruct;
import com.araditc.pushnotification.struct.TextStruct;
import com.araditc.pushnotification.struct.VideoStruct;

public abstract class DataObserver {
    public void onAudioReceived(AudioStruct audioStruct) {

    }

    public void onContactReceived(ContactStruct contactStruct) {

    }

    public void onDocumentReceived(DocumentStruct documentStruct) {

    }

    public void onImageReceived(ImageStruct imageStruct) {

    }

    public void onLocationReceived(LocationStruct locationStruct) {

    }

    public void onTextReceived(TextStruct textStruct) {

    }

    public void onVideoReceived(VideoStruct videoStruct) {

    }

    public void onCustomReceived(CustomStruct customStruct) {

    }
}