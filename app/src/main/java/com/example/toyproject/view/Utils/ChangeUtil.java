package com.example.toyproject.view.Utils;

import com.example.toyproject.MainInterface;
import com.example.toyproject.databinding.PapagoFragmentBinding;

public class ChangeUtil {
    public static void changeText(String setLanguage, PapagoFragmentBinding binding) {
        switch (setLanguage) {
            case "ko":
                binding.textButton.setText("한국어");
                break;

            case "en":
                binding.textButton.setText("영어");
                break;

            case "zh-CN":
                binding.textButton.setText("중국어(간체)");
                break;

            case "zh-TW":
                binding.textButton.setText("중국어(번체)");
                break;

            case "es":
                binding.textButton.setText("스페인어");
                break;

            case "fr":
                binding.textButton.setText("프랑스어");
                break;

            case "vi":
                binding.textButton.setText("베트남어");
                break;

            case "th":
                binding.textButton.setText("태국어");
                break;

            case "id":
                binding.textButton.setText("인도네시아어");
                break;
        }
    }

    public static void changeText2(String changeLanguage, PapagoFragmentBinding binding) {
        switch (changeLanguage) {
            case "ko":
                binding.textButton2.setText("한국어");
                break;

            case "en":
                binding.textButton2.setText("영어");
                break;

            case "zh-CN":
                binding.textButton2.setText("중국어(간체)");
                break;

            case "zh-TW":
                binding.textButton2.setText("중국어(번체)");
                break;

            case "es":
                binding.textButton2.setText("스페인어");
                break;

            case "fr":
                binding.textButton2.setText("프랑스어");
                break;

            case "vi":
                binding.textButton2.setText("베트남어");
                break;

            case "th":
                binding.textButton2.setText("태국어");
                break;

            case "id":
                binding.textButton2.setText("인도네시아어");
                break;
        }
    }

    public static void selectViewLanguage(MainInterface callback,int position){
        switch (position){
            case 0:
                callback.setData("ko");
                break;

            case 1:
                callback.setData("en");
                break;

            case 2:
                callback.setData("zh-CN");
                break;

            case 3:
                callback.setData("zh-TW");
                break;

            case 4:
                callback.setData("es");
                break;

            case 5:
                callback.setData("fr");
                break;

            case 6:
                callback.setData("vi");
                break;

            case 7:
                callback.setData("th");
                break;

            case 8:
                callback.setData("id");
                break;
        }
    }

    public static void selectViewLanguage2(MainInterface callback,int position) {
        switch (position) {
            case 0:
                callback.setData2("ko");
                break;

            case 1:
                callback.setData2("en");
                break;

            case 2:
                callback.setData2("zh-CN");
                break;

            case 3:
                callback.setData2("zh-TW");
                break;

            case 4:
                callback.setData2("es");
                break;

            case 5:
                callback.setData2("fr");
                break;

            case 6:
                callback.setData2("vi");
                break;

            case 7:
                callback.setData2("th");
                break;

            case 8:
                callback.setData2("id");
                break;
        }
    }
}
