/*
 * Copyright © 2019 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtproject.dom.client;

import elemental2.dom.HTMLLinkElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.gwtproject.core.client.JavaScriptObject;
import org.gwtproject.safehtml.shared.annotations.IsTrustedResourceUri;

/**
 * The LINK element specifies a link to an external resource, and defines this document's
 * relationship to that resource (or vice versa).
 *
 * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#edef-LINK">W3C
 *     HTML Specification</a>
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
@TagName(LinkElement.TAG)
public class LinkElement extends Element {

  @JsOverlay public static final String TAG = "link";

  /**
   * Assert that the given {@link Element} is compatible with this class and automatically typecast
   * it.
   *
   * @param elem the element to assert is an instance of this type
   * @return the element, cast to this type
   */
  @JsOverlay
  public static LinkElement as(Element elem) {
    assert is(elem);
    return (LinkElement) elem;
  }

  /**
   * Determines whether the given {@link JavaScriptObject} can be cast to this class. A <code>null
   * </code> object will cause this method to return <code>false</code>.
   *
   * @param o the object to check if it is an instance of this type
   * @return true of the object is an instance of this type, false otherwise
   */
  @JsOverlay
  public static boolean is(JavaScriptObject o) {
    if (Element.is(o)) {
      return is((Element) o);
    }
    return false;
  }

  /**
   * Determine whether the given {@link Node} can be cast to this class. A <code>null</code> node
   * will cause this method to return <code>false</code>.
   *
   * @param node the node to check if it is an instance of this type
   * @return true if the node is an instance of this type, false otherwise
   */
  @JsOverlay
  public static boolean is(Node node) {
    if (Element.is(node)) {
      return is((Element) node);
    }
    return false;
  }

  /**
   * Determine whether the given {@link Element} can be cast to this class. A <code>null</code> node
   * will cause this method to return <code>false</code>.
   *
   * @param elem the element to check if it is an instance of this type
   * @return true if the element is an instance of this type, false otherwise
   */
  @JsOverlay
  public static boolean is(Element elem) {
    return elem != null && elem.hasTagName(TAG);
  }

  protected LinkElement() {}

  /**
   * The URI of the linked resource.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-href">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getHref();

  /**
   * Language code of the linked resource.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-hreflang">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getHreflang();

  /**
   * Designed for use with one or more target media.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/present/styles.html#adef-media">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getMedia();

  /**
   * Forward link type.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-rel">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getRel();

  /**
   * Frame to render the resource in.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/present/frames.html#adef-target">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getTarget();

  /**
   * Advisory content type.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-type-A">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native String getType();

  /**
   * Enables/disables the link. This is currently only used for style sheet links, and may be used
   * to activate or deactivate style sheets.
   */
  @JsOverlay
  public final boolean isDisabled() {
    return Js.isTruthy(Js.<HTMLLinkElement>uncheckedCast(this).disabled);
  }

  /**
   * Enables/disables the link. This is currently only used for style sheet links, and may be used
   * to activate or deactivate style sheets.
   */
  @JsProperty
  public final native void setDisabled(boolean disabled);

  /**
   * The URI of the linked resource.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-href">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setHref(@IsTrustedResourceUri String href);

  /**
   * Language code of the linked resource.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-hreflang">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setHreflang(String hreflang);

  /**
   * Designed for use with one or more target media.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/present/styles.html#adef-media">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setMedia(String media);

  /**
   * Forward link type.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-rel">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setRel(String rel);

  /**
   * Frame to render the resource in.
   *
   * @see <a
   *     href="http://www.w3.org/TR/1999/REC-html401-19991224/present/frames.html#adef-target">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setTarget(String target);

  /**
   * Advisory content type.
   *
   * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#adef-type-A">W3C
   *     HTML Specification</a>
   */
  @JsProperty
  public final native void setType(String type);
}
