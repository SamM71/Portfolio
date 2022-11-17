using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{
    public static bool timed;

    public void Start()
    {
        //MainMenu mm = new MainMenu(timed = false);
        
    }
    public void PlayGame()
    {
        timed = false;
        
        //timed = false;
        SceneManager.LoadScene("Preload");
    }

    public void PlayTimed()
    {
        timed = true;
        SceneManager.LoadScene("PreloadTimed");
    }

    public void QuitGame()
    {
        Application.Quit();
    }

    public void SetTimed(bool timed)
    {
        
    }
}
