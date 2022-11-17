using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    private SpriteRenderer spriteRenderer;
    public Sprite[] runSprites;
    public Sprite climbSprite;
    public int spriteIndex;

    public Sprite[] starRunSprites;
    public Sprite starClimbSprite;
    public int starSpriteIndex;

    private new Rigidbody2D rigidbody;
    private new Collider2D collider;

    private Collider2D[] results;
    private Vector2 direction;

    private bool grounded;
    private bool climbing;

    public float moveSpeed = 1f;
    public float jumpStrength = 1f;

    private SoundManager sm;

    private bool invincible;

    private void Awake()
    {
        spriteRenderer = GetComponent<SpriteRenderer>();
        rigidbody = GetComponent<Rigidbody2D>();
        collider = GetComponent<Collider2D>();
        results = new Collider2D[4];

        sm = GetComponent<SoundManager>();
    }

    private void OnEnable()
    {
        InvokeRepeating(nameof(AnimateSprite), 1f/12f, 1f/12f);
    }

    private void OnDisable()
    {
        CancelInvoke();
    }

    private void CheckCollision()
    {
        grounded = false;
        climbing = false;

        Vector2 size = collider.bounds.size;
        size.y += 0.1f; //Increase collider y for better results
        size.x /= 2f; //Decrease collider x so looks better with ladders
        int amount = Physics2D.OverlapBoxNonAlloc(transform.position, size, 0f, results);

        for (int i = 0; i < amount; i++)
        {
            GameObject hit = results[i].gameObject;

            //grounded = true if touching platform below player
            if (hit.layer == LayerMask.NameToLayer("Ground"))
            {
                grounded = hit.transform.position.y < (transform.position.y - 0.5f);

                Physics2D.IgnoreCollision(collider, results[i], !grounded);
            }
            else if (hit.layer == LayerMask.NameToLayer("Ladder"))
            {
                /*
                if (Input.GetAxis("Vertical") != 0) { 
                }
                */
                climbing = true;
            }
        }
    }

    private void Update()
    {
        CheckCollision();

        if (climbing)
        {
            direction.y = Input.GetAxis("Vertical") * moveSpeed; //climb
        }
        else if (grounded && Input.GetButtonDown("Jump"))
        {
            direction = Vector2.up * jumpStrength; //jump
            sm.PlayJump();
        } else
        {
            direction += Physics2D.gravity * Time.deltaTime; //fall from jump
        }

        direction.x = Input.GetAxis("Horizontal") * moveSpeed; //move left or right

        if (grounded)
        {
            direction.y = Mathf.Max(direction.y, -1f);
        }
        

        if (direction.x > 0f)
        {
            transform.eulerAngles = Vector3.zero;
        }
        else if (direction.x < 0f)
        {
            transform.eulerAngles = new Vector3(0f, 180f, 0f);
        }
    }

    private void FixedUpdate()
    {
        rigidbody.MovePosition(rigidbody.position + direction * Time.fixedDeltaTime);
    }

    private void AnimateSprite()
    {
        if (invincible)
        {
            if (climbing)
            {
                spriteRenderer.sprite = starClimbSprite;

            }
            else if (direction.x != 0f) //Only animate running if moving left or right
            {
                //Cycle through sprites
                starSpriteIndex++;
                if (starSpriteIndex >= starRunSprites.Length)
                {
                    starSpriteIndex = 0;
                }

                spriteRenderer.sprite = starRunSprites[starSpriteIndex];
            }
        } else
        {
            if (climbing)
            {
                spriteRenderer.sprite = climbSprite;

            }
            else if (direction.x != 0f) //Only animate running if moving left or right
            {
                //Cycle through sprites
                spriteIndex++;
                if (spriteIndex >= runSprites.Length)
                {
                    spriteIndex = 0;
                }

                spriteRenderer.sprite = runSprites[spriteIndex];
            }
        }
        
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Objective"))
        {
            enabled = false;
            FindObjectOfType<GameManager>().LevelComplete();
        } 
        else if (collision.gameObject.CompareTag("Obstacle"))
        {   
            if (invincible)
            {
                Destroy(collision.gameObject);
                Score.score += 100;
            } else
            {
                enabled = false;
                sm.PlayDeath();
                FindObjectOfType<GameManager>().LevelFailed();
            }
            
        }

    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.CompareTag("OneUp"))
        {
            sm.PlayOneUp();
            FindObjectOfType<GameManager>().OneUp();

            AchievementManager.ach01Count += 1;
            Destroy(collision.gameObject);
        }
        if (collision.gameObject.CompareTag("Invincibility"))
        {
            sm.PlayInvincibility();
            AchievementManager.ach01Count += 1;
            Destroy(collision.gameObject);
            invincible = true;
            
            Invoke(nameof(InvincibilityOff), 10f);
            
        }
    }

    private void InvincibilityOff()
    {
        invincible = false;
    }

    

}
