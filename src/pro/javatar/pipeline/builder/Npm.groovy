/**
 * Copyright Javatar LLC 2018 ©
 * Licensed under the License located in the root of this repository (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://github.com/JavatarPro/pipeline-utils/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pro.javatar.pipeline.builder

import pro.javatar.pipeline.service.impl.NpmBuildService

import static pro.javatar.pipeline.service.PipelineDslHolder.dsl

/**
 * @author Borys Zora
 * @since 2018-03-09
 */
class Npm implements Serializable {

    static final String DEFAULT_JENKINS_NPM_TYPE = "nodejs"

    static final String DEFAULT_NPM_LIBRARY_FOLDER = "node_modules"

    static final String DEFAULT_NPM_DISTRIBUTION_FOLDER = "dist"

    String npmVersion

    String npmType = DEFAULT_JENKINS_NPM_TYPE

    String libraryFolder = DEFAULT_NPM_LIBRARY_FOLDER

    String distributionFolder = DEFAULT_NPM_DISTRIBUTION_FOLDER

    String moduleRepository

    int buildTimeoutInMinutes = 10

    String getNpmVersion() {
        return npmVersion
    }

    NpmBuildService build() {
        dsl.echo "NpmBuildService build"
        NpmBuildService npmBuildService = new NpmBuildService()
        dsl.echo "new NpmBuildService() succeeded"
        npmBuildService.setLibraryFolder(libraryFolder)
        dsl.echo "setLibraryFolder succeeded"
        npmBuildService.setType(npmType)
        dsl.echo "setType succeeded"
        npmBuildService.setNpmVersion(npmVersion)
        dsl.echo "setNpmVersion succeeded"
        npmBuildService.setModuleRepository(moduleRepository)
        dsl.echo "setModuleRepository succeeded"
        npmBuildService.setDistributionFolder(distributionFolder)
        dsl.echo "setDistributionFolder succeeded"
        npmBuildService.withUnitTestsTimeout(buildTimeoutInMinutes)
        // npmBuildService.setUp()
        return npmBuildService
    }

    Npm withNpmVersion(String npmVersion) {
        this.npmVersion = npmVersion
        return this
    }

    String getNpmType() {
        return npmType
    }

    Npm withNpmType(String npmType) {
        this.npmType = npmType
        return this
    }

    Npm withLibraryFolder(String libraryFolder) {
        this.libraryFolder = libraryFolder
        return this
    }

    String getLibraryFolder() {
        return libraryFolder
    }

    void setLibraryFolder(String libraryFolder) {
        this.libraryFolder = libraryFolder
    }

    void setNpmVersion(String npmVersion) {
        this.npmVersion = npmVersion
    }

    void setNpmType(String npmType) {
        this.npmType = npmType
    }

    public String getDistributionFolder() {
        return distributionFolder
    }

    public void setDistributionFolder(String distributionFolder) {
        this.distributionFolder = distributionFolder
    }

    public Npm withDistributionFolder(String distributionFolder) {
        this.distributionFolder = distributionFolder
        return this
    }

    String getModuleRepository() {
        return moduleRepository
    }

    void setModuleRepository(String moduleRepository) {
        this.moduleRepository = moduleRepository
    }

    Npm withModuleRepository(String moduleRepository) {
        this.moduleRepository = moduleRepository
        return this
    }

    int getBuildTimeoutInMinutes() {
        return buildTimeoutInMinutes
    }

    void setBuildTimeoutInMinutes(int buildTimeoutInMinutes) {
        this.buildTimeoutInMinutes = buildTimeoutInMinutes
    }

    Npm withBuildTimeoutInMinutes(String buildTimeoutInMinutes) {
        this.buildTimeoutInMinutes = Integer.parseInt(buildTimeoutInMinutes)
        return this
    }

    @Override
    public String toString() {
        return "Npm{" +
                "npmVersion='" + npmVersion + '\'' +
                ", npmType='" + npmType + '\'' +
                ", libraryFolder='" + libraryFolder + '\'' +
                ", distributionFolder='" + distributionFolder + '\'' +
                '}';
    }
}
