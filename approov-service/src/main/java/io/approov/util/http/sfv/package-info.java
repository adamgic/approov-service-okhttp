/**
 * Implementation of <a href= "https://www.rfc-editor.org/rfc/rfc8941.html">IETF
 * RFC 8941: Structured Field Values for HTTP</a>.
 * <p>
 * Includes a {@link io.approov.util.http.sfv.Parser} and object equivalents of the defined data types
 * (see {@link io.approov.util.http.sfv.Type}).
 * <p>
 * Here's a minimal example:
 * 
 * <pre><code>
 * {
 *     Parser p = new Parser("a=?0, b, c; foo=bar");
 *     Dictionary d = p.parseDictionary();
 *     for (Map.Entry&lt;String, Item&lt;? extends Object&gt;&gt; e : d.get()) {
 *         String key = e.getKey();
 *         Item&lt;? extends Object&gt; item = e.getValue();
 *         Object value = item.get();
 *         Parameters params = item.getParams();
 *         System.out.println(key + " -&gt; " + value + (params.isEmpty() ? "" : (" (" + params.serialize() + ")")));
 *     }
 * }
 * </code></pre>
 * <p>
 * gives:
 * 
 * <pre>
 * a -&gt; false
 * b -&gt; true
 * c -&gt; true (;foo=bar)
 * </pre>
 */

package io.approov.util.http.sfv;
