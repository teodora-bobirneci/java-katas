Confidential!

Meanwhile... somewhere in a Pentagon basement
Your job is to compare two confidential documents that have come into your possession.
The first document has parts redacted, and the other one hasn't.

But the original (unredacted) document might be a fake!
You need to compare the two documents and decide if it is possible they are the same or not.

Task
Return true if the two documents are possibly the same. Return false otherwise.

Notes
Each document is made of any visible characters, spaces, punctuation, and newlines \n
Any character might be redacted (except \n)
The redaction character is X
The redacted document is always the first one

Examples

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
|                Document 1 (redacted)                                  |                Document 2 (redacted)                                  | Possibly same?  |
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
|TOP SECRET:                                                            |TOP SECRET:                                                            |                 |
|The missile launch code for Sunday XXXXXXXXXX is:                      |The missile launch code for Sunday 5th August is:                      |       true      |
|XXXXXXXXXXXXXXXXX                                                      |7-ZERO-8X-ALPHA-1                                                      |                 |
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
|The name of the mole is Professor XXXXX                                |The name of the mole is Professor Plum                                 |      false      |
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
|XXXXXXXX XXXXXXX XXXXXXXXXXXXXXXXXXX                                   |Area-51. Medical Report. 23/Oct/1969                                   |       true      | 
|XXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXX XXXXXXXXXXXXX XXXXX |E.T. subject 4 was given an asprin after reporting sick for duty today |                 |
-------------------------------------------------------------------------------------------------------------------------------------------------------------------