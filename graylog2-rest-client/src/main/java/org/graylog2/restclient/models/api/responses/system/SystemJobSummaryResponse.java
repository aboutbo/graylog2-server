/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.restclient.models.api.responses.system;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemJobSummaryResponse {

    public String id;
    public String description;
    public String name;
    public String info;

    @JsonProperty("node_id")
    public String nodeId;

    @JsonProperty("started_at")
    public String startedAt;

    @JsonProperty("started_by")
    public String startedBy;

    @JsonProperty("percent_complete")
    public int percentComplete;

    @JsonProperty("is_cancelable")
    public boolean isCancelable;

    @JsonProperty("provides_progress")
    public boolean providesProgress;
}
