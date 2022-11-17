using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    private int level;
    private int lives;
    private int score;
    public GameObject life1, life2, life3, life4, life5, timer;
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
        life4.gameObject.SetActive(false);
        life5.gameObject.SetActive(false);

        //if (!MainMenu.timed)
        if (SceneManager.GetActiveScene().name == "Preload")
        {
            timer.SetActive(false);
        } else
        {
            timer.SetActive(true);
        }
        
        
        //timer.gameObject.SetActive(true);

        Score.score = 0;

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

        if (nextLevel < SceneManager.sceneCountInBuildSettings - 2)
        {
            LoadLevel(nextLevel);
        } else
        {
            /*
            LoadLevel(6);
            level = 1;
            Invoke(nameof(LoadScene), 1f);
            */
            Invoke("Victory", 1f);
        }
        
    }

    public void LevelFailed()
    {
        lives--;
        RemoveHeart();

        if (lives <= 0)
        {
            Invoke("GameOver", 1f);
            //NewGame();
        } else
        {
            //Invoke(nameof(LoadLevel), 1f);
            LoadLevel(level);
        }
    }

    public void TimesUp()
    {
        lives = 0;

        GameOver();
    }

    
    public void RemoveHeart()
    {
        if (life5.activeInHierarchy)
        {
            life5.gameObject.SetActive(false);
        }
        else if (life4.activeInHierarchy)
        {
            life4.gameObject.SetActive(false);
        }
        else if (life3.activeInHierarchy)
        {
            life3.gameObject.SetActive(false);
        } else if (life2.activeInHierarchy)
        {
            life2.gameObject.SetActive(false);
        } else if (life1.activeInHierarchy)
        {
            life1.gameObject.SetActive(false);
        }
    }

    public void GameOver()
    {
        level = SceneManager.sceneCountInBuildSettings - 2;
        life3.gameObject.SetActive(false);
        LoadScene();
        level = 1;
        Invoke(nameof(LoadScene), 3f);

        lives = 3;

        life1.gameObject.SetActive(true);
        life2.gameObject.SetActive(true);
        life3.gameObject.SetActive(true);
      

        FinalScore.score = Score.score;
        CheckHighScore();

        Score.score = 0;
    }

    public void CheckHighScore()
    {
        if (FinalScore.score > PlayerPrefs.GetInt("HighScore")) {
            PlayerPrefs.SetInt("HighScore", FinalScore.score);
        }
    }

    public void Victory()
    {
        level = SceneManager.sceneCountInBuildSettings - 1;
        LoadScene();
        level = 1;
        Invoke(nameof(LoadScene), 3f);

        lives = 3;

        life1.gameObject.SetActive(true);
        life2.gameObject.SetActive(true);
        life3.gameObject.SetActive(true);

        FinalScore.score = Score.score;
        CheckHighScore();
        Score.score = 0;
    }

    public void OneUp()
    {
        
        switch (lives)
        {
            case 1:
                lives += 1;
                break;
            case 2:
                lives += 1;
                life3.gameObject.SetActive(true);
                break;
            case 3:
                lives += 1;
                life4.gameObject.SetActive(true);
                break;
            case 4:
                lives += 1;
                life5.gameObject.SetActive(true);
                break;

        }
        
    }
    

}
