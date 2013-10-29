// Licensed to Cloudera, Inc. under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  Cloudera, Inc. licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.cloudera.api.model;

import com.cloudera.api.ApiUtils;
import com.google.common.base.Objects;

import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/** HBase specific snapshot policy arguments. */
@XmlRootElement(name = "hbaseSnapshotPolicyArguments")
public class ApiHBaseSnapshotPolicyArguments {
  private List<String> tableRegExps;

  public ApiHBaseSnapshotPolicyArguments() {
    // For JAX-B
  }

  public ApiHBaseSnapshotPolicyArguments(List<String> tableRegExps) {
    this.tableRegExps = tableRegExps;
  }

  /**
   * The regular expressions specifying the tables. Tables matching any of them
   * will be eligible for snapshot creation.
   */
  @XmlElementWrapper
  public List<String> getTableRegExps() {
    return tableRegExps;
  }

  public void setTableRegExps(List<String> tableRegExps) {
    this.tableRegExps = tableRegExps;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("tableRegExps", tableRegExps)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    ApiHBaseSnapshotPolicyArguments other = ApiUtils.baseEquals(this, o);
    return this == other || (other != null &&
        Objects.equal(tableRegExps, other.getTableRegExps()));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(tableRegExps);
  }
}
