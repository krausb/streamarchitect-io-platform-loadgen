/*
 * Copyright (C) 2018  Bastian Kraus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.streamarchitect.platform.loadgen

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Main extends App {

  val loadGenClass =
    s"${LoadgenConfig.config.getString("loadGen.package")}.${LoadgenConfig.config.getString("loadGen.class")}"

  val gatlingProperties = new GatlingPropertiesBuilder
  gatlingProperties.simulationClass(loadGenClass)

  Gatling.fromMap(gatlingProperties.build)

  sys.exit()

}
