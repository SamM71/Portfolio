using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SavedInfo : MonoBehaviour
{
    
    void OnQuit()
    {
        PlayerPrefs.SetInt("HighScore", FinalScore.score);
    }
}
