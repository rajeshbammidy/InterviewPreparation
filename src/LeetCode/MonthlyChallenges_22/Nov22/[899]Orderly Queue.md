<p>You are given a string <code>s</code> and an integer <code>k</code>. You can choose one of the first <code>k</code> letters of <code>s</code> and append it at the end of the string..</p>

<p>Return <em>the lexicographically smallest string you could have after applying the mentioned step any number of moves</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "cba", k = 1
<strong>Output:</strong> "acb"
<strong>Explanation:</strong> 
In the first move, we move the 1<sup>st</sup> character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1<sup>st</sup> character 'b' to the end, obtaining the final result "acb".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "baaca", k = 3
<strong>Output:</strong> "aaabc"
<strong>Explanation:</strong> 
In the first move, we move the 1<sup>st</sup> character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3<sup>rd</sup> character 'c' to the end, obtaining the final result "aaabc".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> consist of lowercase English letters.</li> 
</ul>

<div><div>Related Topics</div><div><li>TopicWiseSolutions.Strings.Math</li><li>String</li><li>TopicWiseSolutions.Strings.Sorting</li></div></div><br><div><li>👍 1212</li><li>👎 520</li></div>