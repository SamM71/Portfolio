using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManagerTimed : MonoBehaviour
{
    private int level;
    private int lives;
    private int score;
    public GameObject life1, life2, life3, timer;
    //public static bool timed;

    private void Start()
    {
        DontDestroyOnLoad(gameObject);
        NewGame();
    }

    private void NewGame()
    {
        lives = 3;

        life1.gameObject.SetActive(true);
        life2.gameObject.SetActive(true);
        life3.gameObject.SetActive(true);
        /*
        if (!MainMenu.timed)
        {
            timer.gameObject.SetActive(false);
        } else
        {
            timer.gameObject.SetActive(true);
        }
        */

        timer.gameObject.SetActive(true);

        score = 0;

        LoadLevel(4); //Used to be 1
    }

    private void LoadLevel(int index)
    {
        level = index;

        Camera camera = Camera.main;

        if (camera != null)
        {
            camera.cullingMask = 0;
        }

        //SceneManager.LoadScene(level);
        Invoke(nameof(LoadScene), 1f); //Delay render
    }

    private void LoadScene()
    {
        SceneManager.LoadScene(level);
    }

    public void LevelComplete()
    {
        Score.score += 1000;

        int nextLevel = level + 1;

        if (nextLevel < SceneManager.sceneCountInBuildSettings)
        {
            LoadLevel(nextLevel);
        }
        else
        {
            LoadLevel(1);
        }

    }

    public void LevelFailed()
    {
        lives--;
        RemoveHeart();

        if (lives <= 0)
        {
            NewGame();
        }
        else
        {
            //Invoke(nameof(LoadLevel), 1f);
            LoadLevel(level);
        }
    }


    public void RemoveHeart()
    {
        if (life3.activeInHierarchy)
        {
            life3.gameObject.SetActive(false);
        }
        else if (life2.activeInHierarchy)
        {
            life2.gameObject.SetActive(false);
        }
        else if (life1.activeInHierarchy)
        {
            life1.gameObject.SetActive(false);
        }
    }


}

