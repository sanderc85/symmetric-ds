/**
 * Licensed to JumpMind Inc under one or more contributor
 * license agreements.  See the NOTICE file distributed
 * with this work for additional information regarding
 * copyright ownership.  JumpMind Inc licenses this file
 * to you under the GNU General Public License, version 3.0 (GPLv3)
 * (the "License"); you may not use this file except in compliance
 * with the License.
 *
 * You should have received a copy of the GNU General Public License,
 * version 3.0 (GPLv3) along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jumpmind.symmetric.job;

import org.jumpmind.db.sql.ISqlRowMapper;
import org.jumpmind.db.sql.Row;
import org.jumpmind.symmetric.model.JobDefinition;
import org.jumpmind.symmetric.model.JobDefinition.JobType;

public class JobMapper implements ISqlRowMapper<JobDefinition> {
    @Override
    public JobDefinition mapRow(Row row) {
        JobDefinition jobDefinition = new JobDefinition();
        jobDefinition.setJobName(row.getString("job_name"));
        jobDefinition.setJobType(JobType.valueOf(row.getString("job_type")));
        jobDefinition.setRequiresRegistration(row.getBoolean("requires_registration"));
        jobDefinition.setJobExpression(row.getString("job_expression"));
        jobDefinition.setDescription(row.getString("description"));
        jobDefinition.setDefaultAutomaticStartup(row.getBoolean("default_auto_start"));
        jobDefinition.setDefaultSchedule(row.getString("default_schedule"));
        jobDefinition.setDescription(row.getString("description"));
        jobDefinition.setNodeGroupId(row.getString("node_group_id"));
        jobDefinition.setCreateBy(row.getString("create_by"));
        jobDefinition.setCreateTime(row.getDateTime("create_time"));
        jobDefinition.setLastUpdateBy(row.getString("last_update_by"));
        jobDefinition.setLastUpdateTime(row.getDateTime("last_update_time"));
        return jobDefinition;
    }
}
