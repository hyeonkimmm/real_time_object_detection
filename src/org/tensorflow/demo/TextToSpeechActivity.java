package org.tensorflow.demo;

import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

/**
 * Created by Zoltan Szabo on 4/25/18.
 */

public abstract class TextToSpeechActivity extends CameraActivity implements TextToSpeech.OnInitListener {
    String LOGGING_TAG = "YOLO";
    private TextToSpeech textToSpeech;
    private String lastRecognizedClass = "";
    private int delaytime = 5;
    private int RecentSpeakLp = delaytime;
    private int RecentSpeakRp = delaytime;
    private int RecentSpeakCp = delaytime;
    private int RecentSpeakStair = delaytime;
    private int RecentSpeakFire = delaytime;
    private int RecentSpeaklecture = delaytime;
    private int RecentSpeakcrosswalk = delaytime;
    private int RecentSpeakstopsign = delaytime;
    private int RecentSpeakRedLight = delaytime;
    private int RecentSpeakGreenLight = delaytime;
    private int RecentSpeakCar = delaytime;
    private int RecentSpeakblock = delaytime;


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.KOREA);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(LOGGING_TAG, "Text to speech error: This Language is not supported");
            } else {
                //음성 톤
                textToSpeech.setPitch(0.1f);
                //읽는 속도
                textToSpeech.setSpeechRate(1.0f);
            }
        } else {
            Log.e(LOGGING_TAG, "Text to speech: Initilization Failed!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textToSpeech = new TextToSpeech(this, this);
    }

    protected void speak(List<Classifier.Recognition> results) {// 음성알림
        if (!(results.isEmpty() || lastRecognizedClass.equals(results.get(0).getTitle()))) {
            lastRecognizedClass = results.get(0).getTitle();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_FLUSH, null, null);
            } else {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }
    protected void speaks() {// 음성알림
        lastRecognizedClass = "점자블록";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakblock>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakblock--;
            } else {
                if(RecentSpeakblock == 0){
                    RecentSpeakblock =delaytime;
                }else{
                    RecentSpeakblock--;
                }
            }
        } else {
            if (RecentSpeakblock>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakblock--;
            } else {
                if(RecentSpeakblock == 0){
                    RecentSpeakblock =delaytime;
                }else{
                    RecentSpeakblock--;
                }
            }
        }
    }
    protected void speakCar() {// 음성알림
            lastRecognizedClass = "자동차입니다 주의하세요";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (RecentSpeakCar>delaytime-1) {
                    textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                    RecentSpeakCar--;
                } else {
                    if(RecentSpeakCar == 0){
                        RecentSpeakCar =delaytime;
                    }else{
                        RecentSpeakCar--;
                    }
                }
            } else {
                if (RecentSpeakCar>delaytime-1) {
                    textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                    RecentSpeakCar--;
                } else {
                    if(RecentSpeakCar == 0){
                        RecentSpeakCar =delaytime;
                    }else{
                        RecentSpeakCar--;
                    }
                }
            }
    }

        protected void Speak6109() {
        lastRecognizedClass = "강의실에 도착했습니다";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeaklecture>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeaklecture--;
            } else {
                if(RecentSpeaklecture == 0){
                    RecentSpeaklecture =delaytime;
                }else{
                    RecentSpeaklecture--;
                }
            }
        } else {
            if (RecentSpeaklecture>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeaklecture--;
            } else {
                if(RecentSpeaklecture == 0){
                    RecentSpeaklecture =delaytime;
                }else{
                    RecentSpeaklecture--;
                }
            }
        }
    }

    protected void SpeakStair() {
        lastRecognizedClass = "계단입니다 유의하세요";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakStair>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakStair--;
            } else {
                if(RecentSpeakStair == 0){
                    RecentSpeakStair =delaytime;
                }else{
                    RecentSpeakStair--;
                }
            }
        } else {
            if (RecentSpeakStair>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakStair--;
            } else {
                if(RecentSpeakStair == 0){
                    RecentSpeakStair =delaytime;
                }else {
                    RecentSpeakStair--;
                }
            }
        }
    }
    protected void SpeakFireExtinguisher() {
        lastRecognizedClass = "전방에 소화기가 있습니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakFire>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakFire--;
            } else {
                if(RecentSpeakFire == 0){
                    RecentSpeakFire=delaytime;
                }else{
                    RecentSpeakFire--;
                }
            }
        } else {
            if (RecentSpeakFire>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakFire--;
            } else {
                if(RecentSpeakFire== 0){
                    RecentSpeakFire=delaytime;
                }else{
                    RecentSpeakFire--;
                }
            }
        }
    }

    protected void Leftman() {// 왼쪽 사람
        lastRecognizedClass = "왼쪽에 사람이 오고 있습니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakLp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakLp--;
            } else {
                if(RecentSpeakLp == 0){
                    RecentSpeakLp=delaytime;
                }else{
                    RecentSpeakLp--;
                }
            }
        } else {
            if (RecentSpeakLp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakLp--;
            } else {
                if(RecentSpeakLp== 0){
                    RecentSpeakLp=delaytime;
                }else{
                    RecentSpeakLp--;
                }
            }
        }

    }

    protected void Centerman() {// 중앙 사람
        lastRecognizedClass = "전방에 사람이 오고 있습니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakCp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakCp--;
            } else {
                if(RecentSpeakCp == 0){
                    RecentSpeakCp=delaytime;
                }else{
                    RecentSpeakCp--;
                }
            }
        } else {
            if (RecentSpeakCp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakCp--;
            } else {
                if(RecentSpeakCp== 0){
                    RecentSpeakCp=delaytime;
                }else{
                    RecentSpeakCp--;
                }
            }
        }


    }

    protected void Rightman() {// 전방 사람
        lastRecognizedClass = "오른쪽에 사람이 오고 있습니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakRp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakRp--;
            } else {
                if(RecentSpeakRp == 0){
                    RecentSpeakRp=delaytime;
                }else{
                    RecentSpeakRp--;
                }
            }
        } else {
            if (RecentSpeakRp>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakRp--;
            } else {
                if(RecentSpeakRp== 0){
                    RecentSpeakRp=delaytime;
                }else{
                    RecentSpeakRp--;
                }
            }
        }
    }
    protected void SpeakCrossWalk() {// 전방 횡단보도
        lastRecognizedClass = "횡단보도 입니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakcrosswalk>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakcrosswalk--;
            } else {
                if(RecentSpeakcrosswalk == 0){
                    RecentSpeakcrosswalk=delaytime;
                }else{
                    RecentSpeakcrosswalk--;
                }
            }
        } else {
            if (RecentSpeakcrosswalk>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakcrosswalk--;
            } else {
                if(RecentSpeakcrosswalk== 0){
                    RecentSpeakcrosswalk=delaytime;
                }else{
                    RecentSpeakcrosswalk--;
                }
            }
        }
    }
    protected void SpeakStopSign() {
        lastRecognizedClass = "정지 표지판입니다.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakstopsign>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakstopsign--;
            } else {
                if(RecentSpeakstopsign == 0){
                    RecentSpeakstopsign=delaytime;
                }else{
                    RecentSpeakstopsign--;
                }
            }
        } else {
            if (RecentSpeakstopsign>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakstopsign--;
            } else {
                if(RecentSpeakstopsign== 0){
                    RecentSpeakstopsign=delaytime;
                }else{
                    RecentSpeakstopsign--;
                }
            }
        }
    }
    protected void SpeakRedLight() {
        lastRecognizedClass = "빨간불입니다. 대기하세요";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakRedLight>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakRedLight--;
            } else {
                if(RecentSpeakRedLight == 0){
                    RecentSpeakRedLight=delaytime;
                }else{
                    RecentSpeakRedLight--;
                }
            }
        } else {
            if (RecentSpeakRedLight>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakRedLight--;
            } else {
                if(RecentSpeakRedLight== 0){
                    RecentSpeakRedLight=delaytime;
                }else{
                    RecentSpeakRedLight--;
                }
            }
        }
    }

    protected void SpeakGreenLight() {
        lastRecognizedClass = "녹색불입니다. 진행하세요";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeakGreenLight>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeakGreenLight--;
            } else {
                if(RecentSpeakGreenLight == 0){
                    RecentSpeakGreenLight=delaytime;
                }else{
                    RecentSpeakGreenLight--;
                }
            }
        } else {
            if (RecentSpeakGreenLight>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeakGreenLight--;
            } else {
                if(RecentSpeakGreenLight== 0){
                    RecentSpeakGreenLight=delaytime;
                }else{
                    RecentSpeakGreenLight--;
                }
            }
        }
    }
}
/*

 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (RecentSpeak>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null, null);
                RecentSpeak--;
            } else {
                if(RecentSpeak == 0){
                    RecentSpeak =delaytime;
                }
                RecentSpeak--;
                return;
            }
        } else {
            if (RecentSpeak>delaytime-1) {
                textToSpeech.speak(lastRecognizedClass, TextToSpeech.QUEUE_ADD, null);
                RecentSpeak--;
            } else {
                if(RecentSpeak == 0){
                    RecentSpeak =delaytime;
                    return;
                }else RecentSpeak--;
                return;
            }
        }
        */


