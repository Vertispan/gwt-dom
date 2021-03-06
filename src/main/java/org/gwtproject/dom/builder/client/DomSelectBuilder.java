/*
 * Copyright 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.dom.builder.client;

import org.gwtproject.dom.builder.shared.SelectBuilder;
import org.gwtproject.dom.client.SelectElement;

/**
 * DOM-based implementation of {@link SelectBuilder}.
 */
public class DomSelectBuilder extends DomElementBuilderBase<SelectBuilder, SelectElement> implements
        SelectBuilder {

  DomSelectBuilder(DomBuilderImpl delegate) {
    super(delegate);
  }

  @Override
  public SelectBuilder disabled() {
    assertCanAddAttribute().setDisabled(true);
    return this;
  }

  @Override
  public SelectBuilder multiple() {
    assertCanAddAttribute().setMultiple(true);
    return this;
  }

  @Override
  public SelectBuilder name(String name) {
    assertCanAddAttribute().setName(name);
    return this;
  }

  @Override
  public SelectBuilder selectedIndex(int index) {
    assertCanAddAttribute().setSelectedIndex(index);
    return this;
  }

  @Override
  public SelectBuilder size(int size) {
    assertCanAddAttribute().setSize(size);
    return this;
  }

  @Override
  public SelectBuilder type(String type) {
    assertCanAddAttribute().setType(type);
    return this;
  }

  @Override
  public SelectBuilder value(String value) {
    assertCanAddAttribute().setValue(value);
    return this;
  }
}
