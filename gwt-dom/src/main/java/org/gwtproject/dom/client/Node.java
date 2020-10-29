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

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.gwtproject.core.client.JavaScriptObject;

/**
 * The Node interface is the primary datatype for the entire Document Object Model. It represents a
 * single node in the document tree. While all objects implementing the Node interface expose
 * methods for dealing with children, not all objects implementing the Node interface may have
 * children.
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Node extends JavaScriptObject {

  /** The node is an {@link Element}. */
  @JsProperty(namespace = JsPackage.GLOBAL, name = "Node.ELEMENT_NODE")
  public static short ELEMENT_NODE;

  /** The node is a {@link Text} node. */
  @JsProperty(namespace = JsPackage.GLOBAL, name = "Node.TEXT_NODE")
  public static short TEXT_NODE;

  /** The node is a {@link Document}. */
  @JsProperty(namespace = JsPackage.GLOBAL, name = "Node.DOCUMENT_NODE")
  public static short DOCUMENT_NODE;

  /**
   * Assert that the given {@link JavaScriptObject} is a DOM node and automatically typecast it.
   *
   * @param o the object to assert is a Node
   * @return the object, cast to a Node
   */
  @JsOverlay
  public static Node as(JavaScriptObject o) {
    assert is(o);
    return (Node) o;
  }

  /**
   * Determines whether the given {@link JavaScriptObject} is a DOM node. A <code>null</code> object
   * will cause this method to return <code>false</code>. The try catch is needed for the firefox
   * permission error: "Permission denied to access property 'nodeType'"
   *
   * @param o the object to check if it is an instance of this type
   * @return true of the object is an instance of this type, false otherwise
   */
  @JsOverlay
  public static boolean is(JavaScriptObject o) {
    try {
      return Js.isTruthy(o) && Js.isTruthy(Js.asPropertyMap(o).get("nodeType"));
    } catch (Exception e) {
      return false;
    }
  }

  protected Node() {}

  /**
   * Adds the node newChild to the end of the list of children of this node. If the newChild is
   * already in the tree, it is first removed.
   *
   * @param <T> the type of the node being appended
   * @param newChild The node to add
   * @return The node added
   */
  public final native <T extends Node> T appendChild(T newChild);

  /**
   * Returns a duplicate of this node, i.e., serves as a generic copy constructor for nodes. The
   * duplicate node has no parent; (parentNode is null.).
   *
   * <p>Cloning an Element copies all attributes and their values, including those generated by the
   * XML processor to represent defaulted attributes, but this method does not copy any text it
   * contains unless it is a deep clone, since the text is contained in a child Text node. Cloning
   * an Attribute directly, as opposed to be cloned as part of an Element cloning operation, returns
   * a specified attribute (specified is true). Cloning any other type of node simply returns a copy
   * of this node.
   *
   * @param deep If true, recursively clone the subtree under the specified node; if false, clone
   *     only the node itself (and its attributes, if it is an {@link Element})
   * @return The duplicate node
   */
  public final native Node cloneNode(boolean deep);

  /**
   * Gets the child node at the given index.
   *
   * @param index the index of the node to be retrieved
   * @return the child node at the given index
   */
  @JsOverlay
  public final Node getChild(int index) {
    assert (index >= 0) && (index < getChildCount()) : "Child index out of bounds";

    return getChildNodes().getItem(index);
  }

  /**
   * Gets the number of child nodes contained within this node.
   *
   * @return the number of child nodes
   */
  @JsOverlay
  public final int getChildCount() {
    return getChildNodes().getLength();
  }

  /**
   * A NodeList that contains all children of this node. If there are no children, this is a
   * NodeList containing no nodes.
   *
   * @return the children of this node
   */
  @JsProperty
  public final native NodeList<Node> getChildNodes();

  /**
   * The first child of this node. If there is no such node, this returns null.
   *
   * @return the first child of this node, if any
   */
  @JsProperty
  public final native Node getFirstChild();

  /**
   * The last child of this node. If there is no such node, this returns null.
   *
   * @return the last child of this node, if any
   */
  @JsProperty
  public final native Node getLastChild();

  /**
   * The node immediately following this node. If there is no such node, this returns null.
   *
   * @return the node after this one in this node's parent, if any
   */
  @JsProperty
  public final native Node getNextSibling();

  /**
   * The name of this node, depending on its type; see the table above.
   *
   * @return the name of this node
   */
  @JsProperty
  public final native String getNodeName();

  /**
   * A code representing the type of the underlying object, as defined above.
   *
   * @return a number indicating the type of this node
   */
  @JsProperty
  public final native short getNodeType();

  /**
   * The value of this node, depending on its type; see the table above. When it is defined to be
   * null, setting it has no effect.
   *
   * @return the value of this node
   */
  @JsProperty
  public final native String getNodeValue();

  /**
   * The Document object associated with this node. This is also the {@link Document} object used to
   * create new nodes.
   *
   * @return the document that this node belongs to
   */
  @JsProperty
  public final native Document getOwnerDocument();

  /**
   * Gets the parent element of this node.
   *
   * @return this node's parent element, or <code>null</code> if none exists
   */
  @JsOverlay
  public final Element getParentElement() {
    elemental2.dom.Node parent = Js.<elemental2.dom.Node>uncheckedCast(this).parentNode;
    if (parent == null || parent.nodeType != 1) {
      parent = null;
    }
    return Js.uncheckedCast(parent);
  }

  /**
   * The parent of this node. All nodes except Document may have a parent. However, if a node has
   * just been created and not yet added to the tree, or if it has been removed from the tree, this
   * is null.
   *
   * @return the parent node of this node
   */
  @JsProperty
  public final native Node getParentNode();

  /**
   * The node immediately preceding this node. If there is no such node, this returns null.
   *
   * @return the node before this one in this node's parent, if any
   */
  @JsProperty
  public final native Node getPreviousSibling();

  /**
   * Returns whether this node has any children.
   *
   * @return true if this node has children, false otherwise
   */
  public final native boolean hasChildNodes();

  /**
   * Determines whether this node has a parent element.
   *
   * @return true if the node has a parent element
   */
  @JsOverlay
  public final boolean hasParentElement() {
    return getParentElement() != null;
  }

  /**
   * Inserts the node newChild after the existing child node refChild. If refChild is <code>null
   * </code>, insert newChild at the end of the list of children.
   *
   * @param newChild The node to insert
   * @param refChild The reference node (that is, the node after which the new node must be
   *     inserted), or <code>null</code>
   * @return The node being inserted
   */
  @JsOverlay
  public final Node insertAfter(Node newChild, Node refChild) {
    assert (newChild != null) : "Cannot add a null child node";

    Node next = (refChild == null) ? null : refChild.getNextSibling();
    if (next == null) {
      return appendChild(newChild);
    } else {
      return insertBefore(newChild, next);
    }
  }

  /**
   * Inserts the node newChild before the existing child node refChild. If refChild is <code>null
   * </code>, insert newChild at the end of the list of children.
   *
   * @param newChild The node to insert
   * @param refChild The reference node (that is, the node before which the new node must be
   *     inserted), or <code>null</code>
   * @return The node being inserted
   */
  public final native Node insertBefore(Node newChild, Node refChild);

  /**
   * Inserts the given child as the first child of this node.
   *
   * @param child the child to be inserted
   * @return The node being inserted
   */
  @JsOverlay
  public final Node insertFirst(Node child) {
    assert (child != null) : "Cannot add a null child node";

    return insertBefore(child, getFirstChild());
  }

  /**
   * Determine whether a node is equal to, or the child of, this node.
   *
   * @param child the potential child element
   * @return <code>true</code> if the relationship holds
   */
  @JsOverlay
  public final boolean isOrHasChild(Node child) {
    assert (child != null) : "Child cannot be null";

    return Js.<HTMLElement>uncheckedCast(this).contains(Js.<HTMLElement>uncheckedCast(child));
  }

  /**
   * Removes the child node indicated by oldChild from the list of children, and returns it.
   *
   * @param oldChild The node being removed
   * @return The node removed
   */
  public final native Node removeChild(Node oldChild);

  /**
   * Remove all children of the node.
   *
   * @return always returns null
   */
  @JsOverlay
  public final Node removeAllChildren() {
    while (this.getLastChild() != null) {
      this.removeChild(this.getLastChild());
    }
    return null;
  }

  /** Removes this node from its parent node if it is attached to one. */
  @JsOverlay
  public final void removeFromParent() {
    Element parent = getParentElement();
    if (parent != null) {
      parent.removeChild(this);
    }
  }

  /**
   * Replaces the child node oldChild with newChild in the list of children, and returns the
   * oldChild node.
   *
   * @param newChild The new node to put in the child list
   * @param oldChild The node being replaced in the list
   * @return The node replaced
   */
  public final native Node replaceChild(Node newChild, Node oldChild);

  /**
   * The value of this node, depending on its type; see the table above. When it is defined to be
   * null, setting it has no effect.
   *
   * @param nodeValue the value to assign to the node
   */
  @JsProperty
  public final native void setNodeValue(String nodeValue);
}
