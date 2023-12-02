<p>Given a string <code>s</code>. In one step you can insert any character at any index of the string.</p>

<p>Return <em>the minimum number of steps</em> to make <code>s</code>&nbsp;palindrome.</p>

<p>A&nbsp;<b>Palindrome String</b>&nbsp;is one that reads the same backward as well as forward.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "zzazz"
<strong>Output:</strong> 0
<strong>Explanation:</strong> The string "zzazz" is already palindrome we do not need any insertions.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "mbadm"
<strong>Output:</strong> 2
<strong>Explanation:</strong> String can be "mbdadbm" or "mdbabdm".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "leetcode"
<strong>Output:</strong> 5
<strong>Explanation:</strong> Inserting 5 characters the string becomes "leetcodocteel".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 500</code></li> 
 <li><code>s</code> consists of lowercase English letters.</li> 
</ul>

<div><div>Related Topics</div><div><li>String</li><li>Dynamic Programming</li></div></div><br><div><li>👍 3880</li><li>👎 55</li></div>