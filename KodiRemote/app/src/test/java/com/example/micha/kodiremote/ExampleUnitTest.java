package com.example.micha.kodiremote;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.micha.kodiremote.Kodi.KodiController;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiPlayAndPause;
import com.example.micha.kodiremote.Utills.IPv4Matcher;
import com.example.micha.kodiremote.Utills.KodiParameters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ip_isCorrect() throws Exception {
        IPv4Matcher matcher = new IPv4Matcher("192.168.1.1");
        assertTrue("Correct its ip V4", matcher.isMaching());
    }

    @Test
    public void ip_isWrongDueToWrongNumber() throws Exception {
        IPv4Matcher matcher = new IPv4Matcher("280.1.1.1");
        assertFalse("Correct its not ip V4", matcher.isMaching());
    }

    @Test
    public void ip_isWrongDueToWrongPattern() throws Exception {
        IPv4Matcher matcher = new IPv4Matcher("255.1.1.");
        assertFalse("Correct its not ip V4", matcher.isMaching());
    }
    @Test
    public void play_function_json_reator() throws Exception {
        KodiParameters kp = new KodiParameters();
        kp.setIp("192.168.0.17");
        kp.setPort("8080");
        KodiPlayAndPause kodi = new KodiPlayAndPause(kp);
        kodi.function();
    }

    @Test
    public void create_and_send_request_play_funtest() throws Exception {
        KodiParameters kp = new KodiParameters();
        kp.setIp("192.168.0.17");
        kp.setPort("8080");
        KodiController kc= new KodiController(kp);
        kc.playPause();
    }
    @Test
    public void create_and_send_request_select_fun_test() throws Exception {
        KodiParameters kp = new KodiParameters();
        kp.setIp("192.168.0.17");
        kp.setPort("8080");
        KodiController kc= new KodiController(kp);
        kc.back();
    }
    @Test
    public void set_volume_to_74_test() throws Exception {
        KodiParameters kp = new KodiParameters();
        kp.setIp("192.168.0.17");
        kp.setPort("8080");
        KodiController kc= new KodiController(kp);
        kc.setVolume("1");
    }

}