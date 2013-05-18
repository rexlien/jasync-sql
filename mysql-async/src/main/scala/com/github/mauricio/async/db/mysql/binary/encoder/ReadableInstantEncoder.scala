/*
 * Copyright 2013 Maurício Linhares
 *
 * Maurício Linhares licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.github.mauricio.async.db.mysql.binary.encoder

import org.jboss.netty.buffer.ChannelBuffer
import org.joda.time._
import com.github.mauricio.async.db.mysql.column.ColumnTypes

object ReadableInstantEncoder extends BinaryEncoder {
  def encode(value: Any, buffer: ChannelBuffer) {
    val date = value.asInstanceOf[ReadableInstant]
    LocalDateTimeEncoder.encode(new LocalDate(date.getMillis), buffer)
  }

  def encodesTo: Int = ColumnTypes.FIELD_TYPE_TIMESTAMP
}