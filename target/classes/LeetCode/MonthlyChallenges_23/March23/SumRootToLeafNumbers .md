<p>You are given the <code>root</code> of a binary tree containing digits from <code>0</code> to <code>9</code> only.</p>

<p>Each root-to-leaf path in the tree represents a number.</p>

<ul> 
 <li>For example, the root-to-leaf path <code>1 -&gt; 2 -&gt; 3</code> represents the number <code>123</code>.</li> 
</ul>

<p>Return <em>the total sum of all root-to-leaf numbers</em>. Test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>

<p>A <strong>leaf</strong> node is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg" style="width: 212px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 25
<strong>Explanation:</strong>
The root-to-leaf path <span><code>1-&gt;2</code></span> represents the number <span><code>12</code></span>.
The root-to-leaf path <span><code>1-&gt;3</code></span> represents the number <span><code>13</code></span>.
Therefore, sum = 12 + 13 = <span><code>25</code></span>.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg" style="width: 292px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [4,9,0,5,1]
<strong>Output:</strong> 1026
<strong>Explanation:</strong>
The root-to-leaf path <span><code>4-&gt;9-&gt;5</code></span> represents the number 495.
The root-to-leaf path <span><code>4-&gt;9-&gt;1</code></span> represents the number 491.
The root-to-leaf path <span><code>4-&gt;0</code></span> represents the number 40.
Therefore, sum = 495 + 491 + 40 = <span><code>1026</code></span>.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>The depth of the tree will not exceed <code>10</code>.</li> 
</ul>

<div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 6440</li><li>👎 100</li></div>