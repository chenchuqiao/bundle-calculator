# bundle-calculator
A demo for code review.  
This is a calculator for social media influencers to sell posts in bundles and charge on a per bundle basis. This version bundle calculator supports posts in three formats: Image, Audio, and Video. Given a set of orders, the calculator will help you determine the cost and bundle breakdown for each format order. And you can input a series of format post orders at once. Specific information is as follows.  

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

# usage
- Use the console to input a series of lines with each line containing the number of items followed by the submission format code:  
    ```
    10 IMG
    15 FLAC
    13 VID
    ```
- Wrong input format will be prompted and you can continue to enter the correct format without having to start over.  
- End the input with an extra 'ENTER' and get the output.  
